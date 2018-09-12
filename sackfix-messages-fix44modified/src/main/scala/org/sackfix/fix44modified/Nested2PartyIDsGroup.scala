package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class Nested2PartyIDsGroup(nested2PartyIDField:Option[Nested2PartyIDField]=None,
                                nested2PartyIDSourceField:Option[Nested2PartyIDSourceField]=None,
                                nested2PartyRoleField:Option[Nested2PartyRoleField]=None,
                                noNested2PartySubIDsField:Option[NoNested2PartySubIDsField]=None,
                                nested2PartySubIDsGroups: Option[List[Nested2PartySubIDsGroup]]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {
  if (noNested2PartySubIDsField.map(_.value).getOrElse(0) != nested2PartySubIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoNested2PartySubIDsField.TagId,noNested2PartySubIDsField.map(_.value).getOrElse(0), nested2PartySubIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    nested2PartyIDField.foreach(fmt(b,_))
    nested2PartyIDSourceField.foreach(fmt(b,_))
    nested2PartyRoleField.foreach(fmt(b,_))
    noNested2PartySubIDsField.foreach(fmt(b,_))
    nested2PartySubIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object Nested2PartyIDsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    Nested2PartySubIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    Nested2PartyIDField.TagId, Nested2PartyIDSourceField.TagId, Nested2PartyRoleField.TagId, NoNested2PartySubIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    Nested2PartySubIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    Nested2PartySubIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoNested2PartySubIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==Nested2PartyIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[Nested2PartyIDsGroup]=ArrayBuffer.empty[Nested2PartyIDsGroup]):Option[List[Nested2PartyIDsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[Nested2PartyIDsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[Nested2PartyIDsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(Nested2PartyIDsGroup(myFields.get(Nested2PartyIDField.TagId).flatMap(f=>Nested2PartyIDField.decode(f)),
          myFields.get(Nested2PartyIDSourceField.TagId).flatMap(f=>Nested2PartyIDSourceField.decode(f)),
          myFields.get(Nested2PartyRoleField.TagId).flatMap(f=>Nested2PartyRoleField.decode(f)),
          myFields.get(NoNested2PartySubIDsField.TagId).flatMap(f=>NoNested2PartySubIDsField.decode(f)),
          if (nextTagPosLookup.contains(NoNested2PartySubIDsField.TagId)) Nested2PartySubIDsGroup.decode(flds, nextTagPosLookup(NoNested2PartySubIDsField.TagId)) else None)))
      } else (startPos, None)
    }
  }
    
}
     