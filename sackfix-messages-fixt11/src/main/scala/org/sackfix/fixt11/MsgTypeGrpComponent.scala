package org.sackfix.fixt11

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIXT11.xml
  */
case class MsgTypeGrpComponent(noMsgTypesField:Option[NoMsgTypesField]=None,
                               msgTypesGroups: Option[List[MsgTypesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noMsgTypesField.map(_.value).getOrElse(0) != msgTypesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoMsgTypesField.TagId,noMsgTypesField.map(_.value).getOrElse(0), msgTypesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noMsgTypesField.foreach(fmt(b,_))
    msgTypesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object MsgTypeGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    MsgTypesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoMsgTypesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    MsgTypesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    MsgTypesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoMsgTypesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = MsgTypesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[MsgTypeGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(MsgTypeGrpComponent(myFields.get(NoMsgTypesField.TagId).flatMap(f=>NoMsgTypesField.decode(f)),
        if (nextTagPosLookup.contains(NoMsgTypesField.TagId)) MsgTypesGroup.decode(flds, nextTagPosLookup(NoMsgTypesField.TagId)) else None))
    } else None
  }

    
}
     