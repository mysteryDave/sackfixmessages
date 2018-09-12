package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class FillsGroup(fillExecIDField:Option[FillExecIDField]=None,
                      fillPxField:Option[FillPxField]=None,
                      fillQtyField:Option[FillQtyField]=None,
                      fillLiquidityIndField:Option[FillLiquidityIndField]=None,
                      nestedParties4Component:Option[NestedParties4Component]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fillExecIDField.foreach(fmt(b,_))
    fillPxField.foreach(fmt(b,_))
    fillQtyField.foreach(fmt(b,_))
    fillLiquidityIndField.foreach(fmt(b,_))
    nestedParties4Component.foreach(fmt(b,_))
    b
  }

}
     
object FillsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    NestedParties4Component.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    FillExecIDField.TagId, FillPxField.TagId, FillQtyField.TagId, FillLiquidityIndField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    NestedParties4Component.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    NestedParties4Component.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==FillExecIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[FillsGroup]=ArrayBuffer.empty[FillsGroup]):Option[List[FillsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[FillsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[FillsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(FillsGroup(myFields.get(FillExecIDField.TagId).flatMap(f=>FillExecIDField.decode(f)),
          myFields.get(FillPxField.TagId).flatMap(f=>FillPxField.decode(f)),
          myFields.get(FillQtyField.TagId).flatMap(f=>FillQtyField.decode(f)),
          myFields.get(FillLiquidityIndField.TagId).flatMap(f=>FillLiquidityIndField.decode(f)),
          NestedParties4Component.decode(flds, startPos))))
      } else (startPos, None)
    }
  }
    
}
     