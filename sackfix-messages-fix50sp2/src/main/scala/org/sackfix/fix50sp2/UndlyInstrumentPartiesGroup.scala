package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class UndlyInstrumentPartiesGroup(underlyingInstrumentPartyIDField:Option[UnderlyingInstrumentPartyIDField]=None,
                                       underlyingInstrumentPartyIDSourceField:Option[UnderlyingInstrumentPartyIDSourceField]=None,
                                       underlyingInstrumentPartyRoleField:Option[UnderlyingInstrumentPartyRoleField]=None,
                                       undlyInstrumentPtysSubGrpComponent:Option[UndlyInstrumentPtysSubGrpComponent]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    underlyingInstrumentPartyIDField.foreach(fmt(b,_))
    underlyingInstrumentPartyIDSourceField.foreach(fmt(b,_))
    underlyingInstrumentPartyRoleField.foreach(fmt(b,_))
    undlyInstrumentPtysSubGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object UndlyInstrumentPartiesGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    UndlyInstrumentPtysSubGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    UnderlyingInstrumentPartyIDField.TagId, UnderlyingInstrumentPartyIDSourceField.TagId, UnderlyingInstrumentPartyRoleField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    UndlyInstrumentPtysSubGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    UndlyInstrumentPtysSubGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==UnderlyingInstrumentPartyIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[UndlyInstrumentPartiesGroup]=ArrayBuffer.empty[UndlyInstrumentPartiesGroup]):Option[List[UndlyInstrumentPartiesGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[UndlyInstrumentPartiesGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[UndlyInstrumentPartiesGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(UndlyInstrumentPartiesGroup(myFields.get(UnderlyingInstrumentPartyIDField.TagId).flatMap(f=>UnderlyingInstrumentPartyIDField.decode(f)),
          myFields.get(UnderlyingInstrumentPartyIDSourceField.TagId).flatMap(f=>UnderlyingInstrumentPartyIDSourceField.decode(f)),
          myFields.get(UnderlyingInstrumentPartyRoleField.TagId).flatMap(f=>UnderlyingInstrumentPartyRoleField.decode(f)),
          UndlyInstrumentPtysSubGrpComponent.decode(flds, startPos))))
      } else (startPos, None)
    }
  }
    
}
     