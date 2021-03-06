package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class LegAllocsGroup(legAllocAccountField:Option[LegAllocAccountField]=None,
                          legIndividualAllocIDField:Option[LegIndividualAllocIDField]=None,
                          nestedParties2Component:Option[NestedParties2Component]=None,
                          legAllocQtyField:Option[LegAllocQtyField]=None,
                          legAllocAcctIDSourceField:Option[LegAllocAcctIDSourceField]=None,
                          legSettlCurrencyField:Option[LegSettlCurrencyField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    legAllocAccountField.foreach(fmt(b,_))
    legIndividualAllocIDField.foreach(fmt(b,_))
    nestedParties2Component.foreach(fmt(b,_))
    legAllocQtyField.foreach(fmt(b,_))
    legAllocAcctIDSourceField.foreach(fmt(b,_))
    legSettlCurrencyField.foreach(fmt(b,_))
    b
  }

}
     
object LegAllocsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    NestedParties2Component.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    LegAllocAccountField.TagId, LegIndividualAllocIDField.TagId, LegAllocQtyField.TagId, LegAllocAcctIDSourceField.TagId, LegSettlCurrencyField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    NestedParties2Component.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    NestedParties2Component.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==LegAllocAccountField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[LegAllocsGroup]=ArrayBuffer.empty[LegAllocsGroup]):Option[List[LegAllocsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[LegAllocsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[LegAllocsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(LegAllocsGroup(myFields.get(LegAllocAccountField.TagId).flatMap(f=>LegAllocAccountField.decode(f)),
          myFields.get(LegIndividualAllocIDField.TagId).flatMap(f=>LegIndividualAllocIDField.decode(f)),
          NestedParties2Component.decode(flds, startPos),
          myFields.get(LegAllocQtyField.TagId).flatMap(f=>LegAllocQtyField.decode(f)),
          myFields.get(LegAllocAcctIDSourceField.TagId).flatMap(f=>LegAllocAcctIDSourceField.decode(f)),
          myFields.get(LegSettlCurrencyField.TagId).flatMap(f=>LegSettlCurrencyField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     