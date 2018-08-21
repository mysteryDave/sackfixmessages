package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class SettlPartyIDsGroup(settlPartyIDField:Option[SettlPartyIDField]=None,
                              settlPartyIDSourceField:Option[SettlPartyIDSourceField]=None,
                              settlPartyRoleField:Option[SettlPartyRoleField]=None,
                              noSettlPartySubIDsField:Option[NoSettlPartySubIDsField]=None,
                              settlPartySubIDsGroups: Option[List[SettlPartySubIDsGroup]]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {
  if (noSettlPartySubIDsField.map(_.value).getOrElse(0) != settlPartySubIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoSettlPartySubIDsField.TagId,noSettlPartySubIDsField.map(_.value).getOrElse(0), settlPartySubIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    settlPartyIDField.foreach(fmt(b,_))
    settlPartyIDSourceField.foreach(fmt(b,_))
    settlPartyRoleField.foreach(fmt(b,_))
    noSettlPartySubIDsField.foreach(fmt(b,_))
    settlPartySubIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object SettlPartyIDsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    SettlPartySubIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SettlPartyIDField.TagId, SettlPartyIDSourceField.TagId, SettlPartyRoleField.TagId, NoSettlPartySubIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    SettlPartySubIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    SettlPartySubIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoSettlPartySubIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SettlPartyIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[SettlPartyIDsGroup]=ArrayBuffer.empty[SettlPartyIDsGroup]):Option[List[SettlPartyIDsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[SettlPartyIDsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[SettlPartyIDsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(SettlPartyIDsGroup(myFields.get(SettlPartyIDField.TagId).flatMap(f=>SettlPartyIDField.decode(f)),
          myFields.get(SettlPartyIDSourceField.TagId).flatMap(f=>SettlPartyIDSourceField.decode(f)),
          myFields.get(SettlPartyRoleField.TagId).flatMap(f=>SettlPartyRoleField.decode(f)),
          myFields.get(NoSettlPartySubIDsField.TagId).flatMap(f=>NoSettlPartySubIDsField.decode(f)),
          if (nextTagPosLookup.contains(NoSettlPartySubIDsField.TagId)) SettlPartySubIDsGroup.decode(flds, nextTagPosLookup(NoSettlPartySubIDsField.TagId)) else None)))
      } else (startPos, None)
    }
  }
    
}
     